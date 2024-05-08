import axios from 'axios';

const DOCTORS_ENDPOINT = 'http://localhost:8080/doctors'

export const getAllDoctors = () => axios.get(DOCTORS_ENDPOINT)
export const getAllUnverifiedDoctors = () => axios.get(DOCTORS_ENDPOINT + '?verified=false')
export const getDoctorsByPattern = (pattern) => axios.get(DOCTORS_ENDPOINT + '?pattern=' + pattern)
export const getDoctorById = (id) => axios.get(DOCTORS_ENDPOINT + "/" + id)
export const updateDoctor = (id, doctor) => axios.put(DOCTORS_ENDPOINT + "/" + id, doctor)
export const deleteDoctorById = (id) => axios.delete(DOCTORS_ENDPOINT + "/" + id)