import { Input, InputGroup, InputLeftElement } from '@chakra-ui/react';
import {SearchIcon} from "@chakra-ui/icons"
import {useEffect, useState} from "react";
import useAxiosPrivate from "../../../hooks/useAxiosPrivate.js";

export default function SearchBar( {setData, searchCollection} ) {

    const [pattern, setPattern] = useState("")
    const axiosPrivate = useAxiosPrivate()

    useEffect(() => {
        const searchByPattern = pattern => {
            console.log(pattern)
            let req
            if (searchCollection === "patients" && pattern) {
                req = axiosPrivate.get("/patients?pattern=" + pattern)
            } else if (searchCollection === "doctors" && pattern) {
                req = axiosPrivate.get("/doctors?pattern=" + pattern)
            } else if (searchCollection === "patients") {
                req = axiosPrivate.get("/patients")
            } else if (searchCollection === "doctors") {
                req = axiosPrivate.get("/doctors")
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