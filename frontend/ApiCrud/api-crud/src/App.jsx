import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import FooterComponent from './components/FooterComponent';
import HederKaryawan from './components/HederKaryawan';
import KaryawanComponent from './components/KaryawanComponents';
import ListKaryawanComponent from './components/ListKaryawanComponent';

function App() {
  return (
    <BrowserRouter>
      <HederKaryawan />
      <Routes>
        <Route path="/" element={<ListKaryawanComponent />} />
        <Route path="/add-karyawan" element={<KaryawanComponent />} />
        <Route path="/edit-karyawan/:id" element={<KaryawanComponent />} />
      </Routes>
      <FooterComponent />
    </BrowserRouter>
  );
}

export default App;
