import { Input, InputGroup, InputLeftElement } from '@chakra-ui/react';
import {SearchIcon} from "@chakra-ui/icons"
import {getAllPatients, getPatientsByPattern} from "../../../service/PatientService.js";
import {getAllDoctors, getDoctorsByPattern} from "../../../service/DoctorService.js";
import {useEffect, useState} from "react";

export default function SearchBar( {setData, searchCollection} ) {

    const [pattern, setPattern] = useState("")

    useEffect(() => {
        const searchByPattern = pattern => {
            console.log(pattern)
            let req
            if (searchCollection === "patients" && pattern) {
                req = getPatientsByPattern(pattern)
            } else if (searchCollection === "doctors" && pattern) {
                req = getDoctorsByPattern(pattern)
            } else if (searchCollection === "patients") {
                req = getAllPatients()
            } else if (searchCollection === "doctors") {
                req = getAllDoctors()
            } else {
                throw new Error("We can search either patients or doctors")
            }
            req
                .then(res => setData(res.data))
                .catch(err => console.error(err))
        };

        const timeOutId = setTimeout(() => searchByPattern(pattern), 500)
        return () => clearTimeout(timeOutId)
    }, [pattern, searchCollection, setData]);

    return (
        <>
            <InputGroup w="25%" margin="auto">
                <InputLeftElement pointerEvents="none" >
                    <SearchIcon color="gray.300" />
                </InputLeftElement>
                <Input type="text" placeholder="Search..." onChange={(e) => setPattern(e.target.value.toLowerCase())} />
            </InputGroup>
        </>
    )
}