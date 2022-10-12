import axios from 'axios'


const API_URL = "http://localhost:8091/api/auth/";

class AuthService{
    
    signup(username, email, password, role) {
        return axios.post(API_URL +"signup", {
            username,
            email,
            password,
            role
        });
    }

    getCurrentUser() {
        return JSON.parse(localStorage.getItem('user'));
    }
}

export default new AuthService();
