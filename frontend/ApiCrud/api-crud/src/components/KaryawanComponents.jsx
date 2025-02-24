import React, { useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';
import { createKaryawan } from '../services/ListKaryawan';

function KaryawanComponents() {
  const [firstName, setFirstName] = useState('');
  const [lastName, setLastName] = useState('');
  const [email, setEmail] = useState('');
  const [loading, setLoading] = useState(false); // State untuk loading
  const [error, setError] = useState(null); // State untuk error API

  const { id } = useParams();
  const [errors, setErrors] = useState({
    firstName: '',
    lastName: '',
    email: ''
  });

  const navigate = useNavigate();

  function validationForm() {
    let valid = true;
    const errorsCopy = { firstName: '', lastName: '', email: '' };

    if (!firstName.trim()) {
      errorsCopy.firstName = 'Nama awal harus diisi';
      valid = false;
    }

    if (!lastName.trim()) {
      errorsCopy.lastName = 'Nama akhir harus diisi';
      valid = false;
    }

    if (!email.trim()) {
      errorsCopy.email = 'Email harus diisi';
      valid = false;
    }

    setErrors(errorsCopy);
    return valid;
  }

  async function saveKaryawan(e) {
    e.preventDefault();
    setError(null); // Reset error

    if (!validationForm()) return; // Cek validasi sebelum submit

    setLoading(true); // Aktifkan loading
    
    const newKaryawan = { firstName, lastName, email };
    console.log('Data Karyawan:', newKaryawan);

    try {
      const response = await createKaryawan(newKaryawan);
      console.log('Response:', response.data);
      navigate('/'); // Redirect jika berhasil
    } catch (err) {
      console.error('Error:', err);
      setError('Gagal menambahkan karyawan. Coba lagi.'); // Simpan pesan error
    } finally {
      setLoading(false); // Matikan loading setelah selesai
    }
  }

  function pageTitle() {
    return id ? 'Update Karyawan' : 'Tambah Karyawan';
  }

  return (
    <div className="container my-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card">
            <h2 className="card-header text-center">{pageTitle()}</h2>
            <div className="card-body">
              {error && <div className="alert alert-danger">{error}</div>}
              <form onSubmit={saveKaryawan}>
                <div className="form-group mb-3">
                  <label htmlFor="firstName">Nama Awal:</label>
                  <input
                    type="text"
                    className={`form-control ${errors.firstName ? 'is-invalid' : ''}`}
                    id="firstName"
                    placeholder="Masukkan nama awal"
                    value={firstName}
                    onChange={(e) => setFirstName(e.target.value)}
                  />
                  {errors.firstName && <div className="invalid-feedback">{errors.firstName}</div>}
                </div>
                <div className="form-group mb-3">
                  <label htmlFor="lastName">Nama Akhir:</label>
                  <input
                    type="text"
                    className={`form-control ${errors.lastName ? 'is-invalid' : ''}`}
                    id="lastName"
                    placeholder="Masukkan nama terakhir"
                    value={lastName}
                    onChange={(e) => setLastName(e.target.value)}
                  />
                  {errors.lastName && <div className="invalid-feedback">{errors.lastName}</div>}
                </div>
                <div className="form-group mb-3">
                  <label htmlFor="email">Email:</label>
                  <input
                    type="email"
                    className={`form-control ${errors.email ? 'is-invalid' : ''}`}
                    id="email"
                    placeholder="Masukkan email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                  />
                  {errors.email && <div className="invalid-feedback">{errors.email}</div>}
                </div>
                <button type="submit" className="btn btn-primary w-100" disabled={loading}>  
                  {loading ? 'Menyimpan...' : 'Simpan'}
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default KaryawanComponents;
