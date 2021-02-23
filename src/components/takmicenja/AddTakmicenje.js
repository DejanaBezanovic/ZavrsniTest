import React from 'react';
import AppAxios from './../../apis/AppAxios';
import {Button, Form} from "react-bootstrap";



class AddTakmicenje extends React.Component {

    constructor(props) {
        super(props);

        let takmicenje = {
            naziv: '',
            mesto: '',
            datumPocetka: '',
            datumZavrsetka: '',
            formatId: -1
        }

        this.state = {
            formati: [],
            takmicenje: takmicenje
        }

    }

    componentDidMount() {
        this.getFormati()
    }

    getFormati() {
        AppAxios.get('/formati')
        .then(res => {
            console.log(res);
            this.setState({formati: res.data});
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
    
        let takmicenje = this.state.takmicenje;
        takmicenje[name] = value;
    
        this.setState({ takmicenje: takmicenje });
      }

      create() {

        AppAxios.post('/takmicenja', this.state.takmicenje)
        .then(res => {
            // handle success
            console.log(res);
           
            alert('Takmicenje was added successfully!');
            this.props.history.push('/takmicenja');
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Error occured please try again!');
         });
      }

      render() {
        return(
            <div>
        <h1>Dodaj Takmicenje</h1>
        <Form>
          <Form.Group>
            <Form.Label>Naziv</Form.Label>
            <Form.Control
              onChange={(event) => this.valueInputChanged(event)}
              name="naziv"
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Mesto</Form.Label>
            <Form.Control
              onChange={(event) => this.valueInputChanged(event)}
              name="mesto"
            //   value={this.state.narudzbina.datum}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Datum pocetka</Form.Label>
            <Form.Control
              onChange={(event) => this.valueInputChanged(event)}
              name="datumPocetka"
            //   value={this.state.narudzbina.mestoIsporuke}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Datum zavrsetka</Form.Label>
            <Form.Control
              onChange={(event) => this.valueInputChanged(event)}
              name="datumZavrsetka"
            //   value={this.state.narudzbina.cena}
              as="input"
            ></Form.Control>
          </Form.Group>
          <Form.Group>
            <Form.Label>Format</Form.Label>
            <Form.Control
              onChange={(event) => this.valueInputChanged(event)}
              name="formatId"
            //   value={this.state.narudzbina.deliveryId}
              as="select"
            >
              <option value={-1}></option>
              {this.state.formati.map((formati) => {
                return (
                  <option value={formati.id} key={formati.id}>
                    {formati.tip}
                  </option>
                );
              })}
            </Form.Control>
          </Form.Group>
          <Button variant="primary" onClick={() => this.create()}>
            Add
          </Button>
        </Form>
        </div>
        )
    }
}



export default AddTakmicenje;
