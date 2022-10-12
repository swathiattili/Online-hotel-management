import React, { useState, useEffect } from "react";
import { Link } from "react-router-dom";
import axios from "axios";


import { useHistory } from "react-router-dom";


const SignIn = () => {
  //var auth = JSON.stringify(localStorage.getItem("auth"));

  const history = useHistory();
  const [role, setRole] = useState('')
  const [input, setInput] = useState({
    username: "",
    password: "",

  });
  const [formErrors, setFormErrors] = useState({});

  const inputEvent = (event) => {
    const { name, value } = event.target;
    setInput((previousvalue) => {
      console.log(previousvalue.data);
      return {
        ...previousvalue,
        [name]: value,
      };
    });
  };

  const validate = (values) => {
    const errors = {};
    if (!values.username) {
      errors.username = "Username is required!";
    }
    if (!values.password) {
      errors.password = "Password is required";
    }
    if(!values.role){
      errors.role = "Role is required";
    }
    return errors;
  };

  const showdata = async (event) => {
    event.preventDefault();
    setFormErrors(validate(input));
    try {
     
      const { data } = await axios.post("http://localhost:8091/api/auth/signin", {
        username: input.username,
        password: input.password,
        
      });
      console.log(data);
      localStorage.setItem("jwt", JSON.stringify(data));
      localStorage.setItem("username",input.username)
      localStorage.setItem("password",input.password)
      if (data){
        console.log("1111111111111111")
       
        localStorage.setItem('role',data)
        if (role === 'Owner'){
        history.push("/middle");
        }
        else if (role === 'Manager'){
          history.push("/manager");
          }

          else if (role === 'Receptionist'){
            history.push("/receptionist");
            }
  
        
     

      } 
      else{
        alert("Invalid Credentials Please Check your Username and Password")
      }
   
    } catch (error) {
      console.log("error is", error);
    }
  };

  return (
    <><div className="image">
      <div className="col-md-12">
        <div className="signin_container">
          <div className="outer">
            <div className="inner">
            <form>
            
                <h3>Log in</h3>
                <div className="form-group">
                
                <label>UserName</label>
                  <input
                  name="username"
                  type="text"
                  className="form-control"
                  placeholder="Enter username"
                  onChange={inputEvent}
                  value={input.username}
                 
                  />
                </div>
                <p className='errors'>{formErrors.username}</p>
                <div className="form-group">
                
                <label>Password</label>
                  <input
                  name="password"
                  type="password"
                  className="form-control"
                  placeholder="Password"
                  onChange={inputEvent}
                  value={input.password}
                
                  />
                </div>
                <p className='errors'>{formErrors.password}</p>
                <div className="form-group">
                
                <label>Role</label>
                  <input
                  name="role"
                  type="text"
                  className="form-control"
                  placeholder="Role"
                  onChange={(e)=>setRole(e.target.value)}
                  value={input.role}
                 
                  />
                </div>
                <p className='errors'>{formErrors.role}</p>
               
                
                <button className="btn btn-dark btn-block" outline onClick={showdata}>
                  Login
                </button>

                <p>Don't have a account?<Link to="/sign-up"> Register Here</Link></p>
            
            </form>
            </div>
          </div>
        </div>
        </div>
        </div>
    </>
  );
};

export default SignIn;