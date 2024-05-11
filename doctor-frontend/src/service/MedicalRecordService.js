import axios from "axios";

const MEDICAL_RECORD_ENTRIES_ENDPOINT = "http://localhost:8081/entries"

export const getMedicalRecordEntriesByPatientId = (id) => axios.get(
    MEDICAL_RECORD_ENTRIES_ENDPOINT + "/?patientId=" + id
)