import { useMoney } from "../Context/moneyContext";
import { useTotal } from "../Context/totalContext";

const Header = () => {
  const { money } = useMoney();
  const { total } = useTotal();
 
  
  return (
    <>
      <section className="container">
        <div className="textHeader">
          <img src="https://neal.fun/spend/billgates.jpg" alt="" />
          <h2>Spend Bill Gates Money</h2>
        </div>
        <div>
          <h1 className="moneyHeader">{total > 0 ? money - total : money} $</h1>
        </div>
      </section>
    </>
  );
};

export default Header;
