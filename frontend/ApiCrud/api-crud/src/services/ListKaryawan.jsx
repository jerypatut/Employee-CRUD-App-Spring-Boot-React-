import axios from 'axios';

const REST_API_BASE_URL = 'http://localhost:9090/api/karyawan';

export const listKaryawan = async () => {
  try {
    const response = await axios.get(REST_API_BASE_URL);
    return response.data;
  } catch (error) {
    console.error('Error fetching karyawan:', error);
    throw error;
  }
};

export const createKaryawan = async (karyawan) => {
  try {
    const response = await axios.post(REST_API_BASE_URL, karyawan);
    return response.data;
  } catch (error) {
    console.error('Error creating karyawan:', error);
    throw error;
  }
};

export const updateKaryawan = async (id, karyawan) => {
  try {
    const response = await axios.put(`${REST_API_BASE_URL}/${id}`, karyawan);
    return response.data;
  } catch (error) {
    console.error('Error updating karyawan:', error);
    throw error;
  }
};

export const deleteKaryawan = async (id, karyawan) => {
  try {
    const response = await axios.delete(`${REST_API_BASE_URL}/${id}`, karyawan);
    return response.data;
  } catch (error) {
    console.error('error deleting data karyawan', error);
    throw error;
  }
}