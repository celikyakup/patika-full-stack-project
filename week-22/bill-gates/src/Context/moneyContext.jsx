import { useContext } from "react";
import { useState } from "react";
import { createContext } from "react";

const moneyContext = createContext();

// eslint-disable-next-line react/prop-types
export const MoneyProvider = ({ children }) => {
  const [money, setMoney] = useState(100000000000);

  const values = {
    money,
    setMoney,
  };

  return (
    <moneyContext.Provider value={values}>{children}</moneyContext.Provider>
  );
};

export const useMoney = () => useContext(moneyContext);
