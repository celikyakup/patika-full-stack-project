import { useState } from "react";
import { useContext } from "react";
import { createContext } from "react";
const totalContext = createContext();

// eslint-disable-next-line react/prop-types
export const TotalProvider = ({ children }) => {
  // eslint-disable-next-line react-hooks/rules-of-hooks
  const [total, setTotal] = useState(0);
  const totalValues = {
    total,
    setTotal,
  };

  return (
    <totalContext.Provider value={totalValues}>
      {children}
    </totalContext.Provider>
  );
};

export const useTotal = () => useContext(totalContext);
