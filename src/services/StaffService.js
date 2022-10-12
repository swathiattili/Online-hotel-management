import axios from 'axios';
const STAFF_GET_ALL_URL='http://localhost:8085/staff/get';
const STAFF_ADD_URL='http://localhost:8085/staff/add';
const STAFF_DELETE_URL='http://localhost:8085/staff/delete';

class StaffService{

    getAllStaffs(){
        return axios.get(STAFF_GET_ALL_URL);
    }

    addStaffs(staff){
        return axios.post(STAFF_ADD_URL,staff);
    }

    deleteStaff(staffId){
        return axios.delete(STAFF_DELETE_URL + '/' + staffId);
    }

}
export default new StaffService();