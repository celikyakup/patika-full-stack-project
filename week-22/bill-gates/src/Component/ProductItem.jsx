import PropTypes from "prop-types";
import { useBasket } from "../Context/basketProvider";
import { useTotal } from "../Context/totalContext";
import { useEffect } from "react";
import products from "../products.json";
import { useMoney } from "../Context/moneyContext";

const ProductItem = ({ product }) => {
  const { money } = useMoney();
  const { basket, setBasket } = useBasket();
  const { total, setTotal } = useTotal();
  const basketItem = basket.find((item) => item.id === product.id);

  const addBasket = () => {
    const checkBasket = basket.find((item) => item.id === product.id);
    if (checkBasket) {
      checkBasket.amount += 1;
      setBasket([
        ...basket.filter((item) => item.id !== product.id),
        checkBasket,
      ]);
    } else {
      setBasket([
        ...basket,
        {
          id: product.id,
          amount: 1,
        },
      ]);
    }
  };

  const removeBasket = () => {
    const checkBasket = basket.find((item) => item.id === product.id);
    checkBasket.amount -= 1;
    if (checkBasket.amount === 0) {
      setBasket([...basket.filter((item) => item.id !== product.id)]);
    } else {
      setBasket([
        ...basket.filter((item) => item.id !== product.id),
        checkBasket,
      ]);
    }
  };

  useEffect(() => {
    setTotal(
      basket.reduce((acc, item) => {
        return (
          acc +
          item.amount * products.find((product) => product.id === item.id).price
        );
      }, 0)
    );
  }, [basket, setTotal]);

  return (
    <div className="box">
      <img src={product.image} alt="" />
      <h3>{product.title}</h3>
      <h4>{product.price}$</h4>
      <div className="actions">
        <button disabled={!basketItem} onClick={removeBasket}>
          Sell
        </button>
        <span
          style={{
            border: "1px solid",
            width: "40px",
            display: "flex",
            alignItems: "center",
            justifyContent: "center",
          }}
        >
          {(basketItem && basketItem.amount) || 0}
        </span>
        <button
          disabled={total + product.price > money}
          onClick={addBasket}
          style={{
            background: "linear-gradient(180deg,#2ecc71,#1abc9c)",
            border: "none",
            color: "white",
            borderRadius: "2.5px",
          }}
        >
          Buy
        </button>
      </div>
    </div>
  );
};
ProductItem.propTypes = {
  product: {
    id: PropTypes.number.isRequired,
    title: PropTypes.string.isRequired,
    price: PropTypes.number.isRequired,
    image: PropTypes.string.isRequired,
  },
};
export default ProductItem;
