import './App.css';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';
import GlobeScene from './components/GlobeScene.tsx';
import LandingPage from "./components/LandingPage.tsx";

const App = () => {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LandingPage />} />
        <Route path="/globe" element={<GlobeScene />} />
      </Routes>
    </Router>
  )
};

export default App
