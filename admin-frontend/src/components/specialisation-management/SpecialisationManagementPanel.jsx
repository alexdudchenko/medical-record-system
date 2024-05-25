
import {
    Box,
    Button,
    ButtonGroup,
    Flex,
    FormControl,
    FormLabel,
    Heading,
    HStack,
    Input,
    Text,
    VStack
} from "@chakra-ui/react";
import {Link} from "react-router-dom";
import useAxiosPrivate from "../../hooks/useAxiosPrivate.js";
import {useQuery} from "react-query";
import {useState} from "react";

export default function SpecialisationManagementPanel() {

    const axiosPrivate = useAxiosPrivate()

    const [name, setName] = useState("")

    const retrieveSpecialisations = async () => {
        const response = await axiosPrivate.get("/specialisations")
        return response.data
    }

    const deleteSpecialisation = (id) => {
        axiosPrivate.delete(`/specialisations/${id}`)
    }

    const createSpecialisation = () => {
        axiosPrivate.post("/specialisations", {name})
    }

    const {
        data: specialisations
    } = useQuery("hospitalsData", retrieveSpecialisations);


    return (
        <>
            <HStack>
                <VStack>
                    <Heading as="h1">Specialisations</Heading>
                    <Flex direction="column">
                        {
                            specialisations.map((specialisation) => (
                                <Box key={specialisation.id}>
                                    <Text>{specialisation.name}</Text>
                                    <Button color="red" onClick={() => deleteSpecialisation(specialisation.id)}>Delete</Button>
                                </Box>
                            ))
                        }
                    </Flex>
                </VStack>
                <Box w="50%" margin="auto">
                    <FormControl margin="auto">
                        <FormLabel>Specialisation name</FormLabel>
                        <Input type="text"
                               name="name"
                               onChange={(e) => setName(e.target.value)}
                        />
                        <ButtonGroup>
                            <Button type="submit" onClick={createSpecialisation}>Create</Button>
                        </ButtonGroup>
                    </FormControl>
                </Box>
            </HStack>

        </>
    )
}