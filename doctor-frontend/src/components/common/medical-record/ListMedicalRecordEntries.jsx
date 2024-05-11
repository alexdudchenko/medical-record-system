import {useEffect, useState} from "react";
import {Flex, Heading} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import {getMedicalRecordEntriesByPatientId} from "../../../service/MedicalRecordService.js";
import MedicalRecordEntryPreview from "./MedicalRecordEntryPreview.jsx";

export default function ListMedicalRecordEntries() {

    const [records, setRecords] = useState([])

    useEffect(() => {
        getPatients()
    }, []);

    function getPatients() {
        getMedicalRecordEntriesByPatientId(1)
            .then((response) => {
                    setRecords(response.data)
                }
            ).catch((error) => console.error(error)
        )
    }

    return (
        <>
            <Heading as="h1">Medical Record Entries</Heading>
            <Flex wrap="wrap" justify="flex-start">
                {
                    records.map((record) => (
                        <Link key={record.id} to={`${record.id}`}>
                            <MedicalRecordEntryPreview record={record}/>
                        </Link>
                    ))
                }
            </Flex>
        </>
    )
}