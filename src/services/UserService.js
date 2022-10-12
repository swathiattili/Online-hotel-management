import axios from 'axios';
import authHeader from './AuthHeader';

const API_URL = 'http://localhost:8091/api/test/';

class UserService {
  getPublicContent() {
    return axios.get(API_URL + 'all');
  }

  getReceptionist() {
    return axios.get(API_URL + 'Receptionist', { headers: authHeader() });
  }

  getManager() {
    return axios.get(API_URL + 'Manager', { headers: authHeader() });
  }

  getOwner() {
    return axios.get(API_URL + 'Owner', { headers: authHeader() });
  }

}

export default new UserService();