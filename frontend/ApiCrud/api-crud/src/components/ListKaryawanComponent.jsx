import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { deleteKaryawan, listKaryawan } from '../services/ListKaryawan';

const ListKaryawanComponent = () => {
  const [karyawan, setKaryawan] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const navigate = useNavigate();

  useEffect(() => {
    getAllKaryawan();
  }, []);

  const getAllKaryawan = () => {
    listKaryawan()
      .then((response) => {
        setKaryawan(response.data);
        setLoading(false);
      })
      .catch((error) => {
        console.error('Error:', error);
        setError('Gagal mengambil data karyawan.');
        setLoading(false);
      });
  };

  const addNewKaryawan = () => navigate('/add-karyawan');
  const updateKaryawan = (id) => navigate(`/edit-karyawan/${id}`);

  const removeKaryawan = (id) => {
    deleteKaryawan(id)
      .then(() => {
        getAllKaryawan();
      })
      .catch((error) => {
        console.error('Error:', error);
      });
  };

  return (
    <div className='container'>
      <h3 className='text-center'>Daftar Karyawan</h3>

      {error && <div className="alert alert-danger">{error}</div>}

      <button type="button" className='btn btn-primary mb-3' onClick={addNewKaryawan}>
        Tambah Data Karyawan
      </button>

      {loading ? (
        <p className="text-center">Loading data...</p>
      ) : (
        <>
          <p>Jumlah Karyawan: {karyawan.length}</p>
          <table className="table table-striped table-hover">
            <thead>
              <tr>
                <th>Karyawan ID</th>
                <th>Nama Awal</th>
                <th>Nama Akhir</th>
                <th>Email</th>
                <th>Aksi</th>
              </tr>
            </thead>
            <tbody>
              {karyawan.length > 0 ? (
                karyawan.map((k) => (
                  <tr key={k.id || `karyawan-${k.email}`}>
                    <td>{k.id}</td>
                    <td>{k.firstName}</td>
                    <td>{k.lastName}</td>
                    <td>{k.email}</td>
                    <td>
                      <button className='btn btn-info me-2' onClick={() => updateKaryawan(k.id)}>
                        Update
                      </button>
                      <button className='btn btn-danger' onClick={() => removeKaryawan(k.id)}
                      style={{marginLeft:"11px"}}
                      >
                        Delete
                      </button>
                    </td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="5" className="text-center">
                    Tidak ada data karyawan.
                  </td>
                </tr>
              )}
            </tbody>
          </table>
        </>
      )}
    </div>
  );
};

export default ListKaryawanComponent;
