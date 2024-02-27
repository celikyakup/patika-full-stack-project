import "./App.css";

import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import Starships from "./components/starships/Starships";
import Starship from "./components/starship/Starship";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Starships />} />
        <Route path="/starship/:id" element={<Starship />} />
      </Routes>
    </Router>
  );
}

export default App;
