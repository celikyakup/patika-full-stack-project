import "./App.css";
import { MoneyProvider } from "./Context/moneyContext";
import Header from "./Component/Header";
import ProductItem from "./Component/ProductItem";
import products from "./products.json";
import { BasketProvider } from "./Context/basketProvider";
import { TotalProvider } from "./Context/totalContext";
import Basket from "./Component/Basket";


function App() {

  return (
    <MoneyProvider>
      <BasketProvider>
        <TotalProvider>
          <Header />
          <div className="container boxes">
            {products.map((product) => (
              <ProductItem key={product.id} product={product} />
            ))}
          </div>
          <Basket />
        </TotalProvider>
      </BasketProvider>
    </MoneyProvider>
  );
}

export default App;
