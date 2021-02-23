import React from 'react';
import AppAxios from './../../apis/AppAxios';
import {Button, Form} from "react-bootstrap";



class Prijava extends React.Component {

    constructor(props) {
        super(props);

        let prijava = {
            kontakt: '',
            drzava: '',
            takmicenjeId: this.props.match.params.id
        }

        this.state = {prijava: prijava}

    }

    prijava() {

        AppAxios.post("/prijave" , this.state.prijava)
            .then(res => {
                // handle success
                console.log(res);
                alert('Prijava je uspesna!');
                this.props.history.push("/takmicenja");
            })
            .catch(error => {
                // handle error
                console.log(error);
                alert('Error occured please try again!');
            });
        }

        valueInputChanged(e) {
            let input = e.target;
        
            let name = input.name;
            let value = input.value;
        
            let prijava = this.state.prijava;
            prijava[name] = value;
        
            this.setState({ prijava: prijava });
          }

    render() {
         return(
        <div>
            <h1>Dodaj prijavu</h1>
            <Form>
              <Form.Group>
                <Form.Label>Kontakt</Form.Label>
                <Form.Control
                  onChange={(event) => this.valueInputChanged(event)}
                  name="kontakt"
                //   value={this.state.narudzbina.brojNarudzbine}
                  as="input"
              ></Form.Control>
              </Form.Group>
              <Form.Group>
                <Form.Label>Drzava</Form.Label>
                <Form.Control
                  onChange={(event) => this.valueInputChanged(event)}
                  name="drzava"
                //   value={this.state.narudzbina.datum}
                  as="input"
                ></Form.Control>
              </Form.Group>
              <Button variant="primary" onClick={() => this.prijava()}>
                    Add
            </Button>
                </Form>
        </div>
        )
    }
}

export default Prijava;


