
import './App.css';

import {BrowserRouter as Router, Switch, Route} from 'react-router-dom';
import 'bootstrap/dist/css/bootstrap.min.css';
import Navbarcomp from './components/Navbarcomp';
import ManagerProfile from './components/ManagerProfile';

function App() {
  return (
    <>
    <Router>
       <Navbarcomp/>
       <Switch>
        <Route path='/home' exact/>
      
       </Switch>
    </Router>
     
    </>
  );
}

export default App;
