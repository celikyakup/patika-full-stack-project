import { useBasket } from "../Context/basketProvider";
import { useTotal } from "../Context/totalContext";
import products from "../products.json"

const Basket = () => {
  const { basket} = useBasket();
  const {total}=useTotal();

  return (
    <div style={{textAlign:"center",marginTop:"20px", backgroundColor:"white",padding:"20px"}} className="container">
        <h2>Your Receipt</h2>
      {basket.map((item) => (
        <div key={item.id}>{products.find(p=>p.id===item.id).title} x {item.amount}</div>
      ))}
      <div style={{marginTop:"10px"}}>Total: {total}</div>
    </div>
  );
};

export default Basket;
