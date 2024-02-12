import { useContext } from "react";
import { useState } from "react";
import { createContext } from "react";

const basketContext = createContext();

// eslint-disable-next-line react/prop-types
export const BasketProvider = ({ children }) => {
  const [basket, setBasket] = useState([]);
  const basketValues = {
    basket,
    setBasket,
  };

  return (
    <basketContext.Provider value={basketValues}>
      {children}
    </basketContext.Provider>
  );
};

export const useBasket = () => useContext(basketContext);
