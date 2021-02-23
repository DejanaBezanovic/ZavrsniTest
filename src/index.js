import React from 'react';
import ReactDOM from 'react-dom';
import { Route, Link, HashRouter as Router, Switch } from 'react-router-dom';
import {Container, Button, Navbar, Nav} from "react-bootstrap"
import Login from "./components/login/Login"
import Home from './components/Home';
import {logout} from './services/auth'
import Takmicenja from './components/takmicenja/Takmicenja'
import AddTakmicenje from './components/takmicenja/AddTakmicenje'
import Prijava from './components/takmicenja/Prijava'


class App extends React.Component {

    render() {
        return (
            <div>
                <Router>
                    <Navbar expand bg="primary" variant="primary">
                        <Navbar.Brand as={Link} to="/" style={{color: 'white'}} ><strong>TENNIS</strong></Navbar.Brand>
                        <Nav>
                            <Nav.Link as={Link} to="/takmicenja" style={{color: 'white'}}>Takmicenja</Nav.Link>
   
                            {window.localStorage['jwt'] ? 
                            <Button onClick = {()=>logout()}>Logout</Button> :
                            <Nav.Link as={Link} to="/login">Log in</Nav.Link>
                            }
                        </Nav>
                    </Navbar>
                    <Container style={{paddingTop:"25px"}}>
                    <Switch>
                        <Route exact path="/" component={Home} />
                        <Route exact path="/login" component={Login}/>
                        <Route exact path="/takmicenja" component={Takmicenja} />
                        <Route exact path="/takmicenja/add" component={AddTakmicenje} /> 
                        <Route exact path="/takmicenja/prijava/:id" component={Prijava} /> 
                    </Switch>
                    </Container>
                </Router>
            </div>
        );
    }
};


ReactDOM.render(
    <App/>,
    document.querySelector('#root')
);