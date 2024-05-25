import {useState} from "react";
import {Box, Button, ButtonGroup, FormControl, FormLabel, Input} from "@chakra-ui/react";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useMutation, useQueryClient} from "react-query";

export default function CreateHospitalForm() {

    const axiosPrivate = useAxiosPrivate()
    const queryClient = useQueryClient();

    const [name, setName] = useState("")

    const [country, setCountry] = useState("")
    const [city, setCity] = useState("")
    const [line1, setLine1] = useState("")
    const [line2, setLine2] = useState("")
    const [index, setIndex] = useState("")

    const createHospitalMutation = useMutation(() => {
        const hospitalInfo = {
            name: name,
            address: {
                country: country,
                city: city,
                streetLine1: line1,
                streetLine2: line2,
                index: index
            }
        }
        axiosPrivate.post(`/hospitals`, hospitalInfo)
    }, {
        onSuccess: () => {
            queryClient.invalidateQueries("hospitalsData");
        }
    })

    return (
        <>
            <Box w="50%" margin="auto">
                <FormControl margin="auto">
                    <FormLabel>Hospital name</FormLabel>
                    <Input type="text"
                           name="name"
                           onChange={(e) => setName(e.target.value)}
                    />
                    <FormLabel>Country</FormLabel>
                    <Input type="text"
                           name="country"
                           onChange={(e) => setCountry(e.target.value)}
                    />
                    <FormLabel>City</FormLabel>
                    <Input type="text"
                           name="city"
                           onChange={(e) => setCity(e.target.value)}
                    />
                    <FormLabel>Street line 1</FormLabel>
                    <Input type="text"
                           name="line1"
                           onChange={(e) => setLine1(e.target.value)}
                    />
                    <FormLabel>Street line 2</FormLabel>
                    <Input type="text"
                           name="line2"
                           onChange={(e) => setLine2(e.target.value)}
                    />
                    <FormLabel>Index</FormLabel>
                    <Input type="text"
                           name="index"
                           onChange={(e) => setIndex(e.target.value)}
                    />
                    <ButtonGroup>
                        <Button type="submit" onClick={() => createHospitalMutation.mutate()}>Create</Button>
                    </ButtonGroup>
                </FormControl>
            </Box>
        </>
    )
}