import axios from 'axios';

const PATIENTS_ENDPOINT = 'http://localhost:8080/patients'

export const getAllPatients = () => axios.get(PATIENTS_ENDPOINT)
export const getPatientById = (id) => axios.get(PATIENTS_ENDPOINT + "/" + id)
export const updatePatient = (id, patient) => axios.put(PATIENTS_ENDPOINT + "/" + id, patient)
export const deletePatientById = (id) => axios.delete(PATIENTS_ENDPOINT + "/" + id)
export const getPatientsByPattern = (pattern) => axios.get(PATIENTS_ENDPOINT + '?pattern=' + pattern)