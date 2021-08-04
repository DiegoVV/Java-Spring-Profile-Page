import axios from "axios";

const USER_API_BASE_URL = "http://localhost:8080/api/v1/user";
const PHONE_API_BASE_URL = "http://localhost:8080/api/v1/phone";

class UserService {
    getUsers(){
        return axios.get(USER_API_BASE_URL);
    }

    getUser(id){
        return axios.get(USER_API_BASE_URL + "/" + id);
    }

    createUser(user){
        return axios.post(USER_API_BASE_URL, user);
    }

    updateUser(id, user){
        return axios.put(USER_API_BASE_URL + "/" + id, user);
    }

    deleteUser(id){
        return axios.delete(USER_API_BASE_URL + "/" + id);
    }

    loginUser(email, password){
        return axios.get(USER_API_BASE_URL + "/" + email + "/" + password);
    }

    getUserPhones(id){
        return axios.get(PHONE_API_BASE_URL + "/users/" + id);
    }

    createPhone(phone){
        return axios.post(PHONE_API_BASE_URL, phone);
    }

    addPhoneToUser(phoneId, userId){
        return axios.put(PHONE_API_BASE_URL + "/" + phoneId + "/users/" + userId );

    }
}

export default new UserService()