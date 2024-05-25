import React, {useEffect, useState} from "react";
import UserProfilePreview from "../common/user-profile/UserProfilePreview.jsx";
import {Box, Button, ButtonGroup, Flex, FormControl, FormLabel, Heading, Input} from "@chakra-ui/react";
import {Link, useNavigate, useParams} from "react-router-dom";
import SearchBar from "../common/search/SearchBar.jsx";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useQuery} from "react-query";

export default function EditHospitalForm() {

    const axiosPrivate = useAxiosPrivate()
    const navigate = useNavigate()

    const {id} = useParams()

    const [name, setName] = useState("")

    const [country, setCountry] = useState("")
    const [city, setCity] = useState("")
    const [line1, setLine1] = useState("")
    const [line2, setLine2] = useState("")
    const [index, setIndex] = useState("")

    const retrieveHospitalInfo = async () => {
        const response = await axiosPrivate.get(`/hospitals/${id}`)
        return response.data
    }

    const updateHospitalInfo = () => {
        const hospitalInfo = {
            id: id,
            name: name,
            address: {
                id: hospital.address.id,
                country: country,
                city: city,
                streetLine1: line1,
                streetLine2: line2,
                index: index
            }
        }

        axiosPrivate.put(`/hospitals/${id}`, hospitalInfo).then(() => navigate("/hospitals"))
    }

    const {data: hospital} = useQuery("hospitalData", retrieveHospitalInfo)

    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>Hospital name</FormLabel>
                    <Input type="text"
                           value={hospital.name}
                           name="name"
                           onChange={(e) => setName(e.target.value)}
                    />
                    <FormLabel>Country</FormLabel>
                    <Input type="text"
                           value={hospital.address.country}
                           name="name"
                           onChange={(e) => setCountry(e.target.value)}
                    />
                    <FormLabel>City</FormLabel>
                    <Input type="text"
                           value={hospital.address.city}
                           name="name"
                           onChange={(e) => setCity(e.target.value)}
                    />
                    <FormLabel>Street line 1</FormLabel>
                    <Input type="text"
                           value={hospital.address.streetLine1}
                           name="name"
                           onChange={(e) => setLine1(e.target.value)}
                    />
                    <FormLabel>Street line 2</FormLabel>
                    <Input type="text"
                           value={hospital.address.streetLine2}
                           name="name"
                           onChange={(e) => setLine2(e.target.value)}
                    />
                    <FormLabel>Index</FormLabel>
                    <Input type="text"
                           value={hospital.address.index}
                           name="name"
                           onChange={(e) => setIndex(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={updateHospitalInfo}>Update</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}