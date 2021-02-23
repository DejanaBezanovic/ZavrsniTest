import React from 'react';
import AppAxios from './../../apis/AppAxios';
import { Table, Button, Form, ButtonGroup } from "react-bootstrap";

class Takmicenja extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            takmicenja: [],
            pageNo: 0,
            totalPages: 1,
            formati: [],
            pretraga: {mesto: '', formatId: -1 }
        }
    } 

    componentDidMount() {
        this.getTakmicenja(0)
        this.getFormati();
    }

    goToAdd() {
        this.props.history.push("/takmicenja/add");
    }

    getTakmicenja(page) {
        let config = { params: {
            pageNo: page
          } };

        if(this.state.pretraga.mesto !== "") {
            config.params.mesto = this.state.pretraga.mesto;
        }
        if(this.state.pretraga.formatId !== -1) {
          config.params.formatId = this.state.pretraga.formatId;
        } 

        AppAxios.get('/takmicenja', config)
            .then(res => {
                this.setState({
                    pageNo: page,
                    takmicenja: res.data,
                    totalPages: res.headers["total-pages"]
                })
            })
                .catch(error => {
                    // handle error
                    console.log(error);
                    alert('Error occured please try again!');
                });
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

    pretraga() {
        this.getTakmicenja(0)
    }

    prijava(id) {
        this.props.history.push("/takmicenja/prijava/" + id);
    }

    doDelete(id) {
        AppAxios.delete('/takmicenja/' + id)
        .then(res => {
            // handle success
            console.log(res);
            alert('Takmicenje je uspesno obrisano!');
            window.location.reload();
        })
        .catch(error => {
            // handle error
            console.log(error);
            alert('Error occured please try again!');
         });
    }

    pretragaInputChange(e) {
        let control = e.target;

        let name = control.name;
        let value = control.value;
    
        let pretraga = this.state.pretraga;
        pretraga[name] = value;
    
        this.setState({ pretraga: pretraga });
        this.pretraga();
      }

      render() {
        return(
            <div>
                <Form style={{marginTop:35}}>
                <Form.Group>
                    <Form.Label>Mesto</Form.Label>
                    <Form.Control
                      onChange={(e) => this.pretragaInputChange(e)}
                      name="mesto"
                      as="input"
                    ></Form.Control>
                  </Form.Group>
                  <Form.Group>
                    <Form.Label>Format</Form.Label>
                    <Form.Control
                      onChange={(e) => this.pretragaInputChange(e)}
                      name="formatId"
                      value={this.state.pretraga.formatId}
                      as="select"
                    >
                      <option value={-1}></option>
                      {this.state.formati.map((format) => {
                        return (
                          <option value={format.id} key={format.id}>
                            {format.tip}
                          </option>
                        );
                      })}
                    </Form.Control>
                  </Form.Group>
                  </Form>
                  <ButtonGroup style={{ marginTop: 25 }}>
                    <Button 
                        style={{float: 'right'}} disabled={this.state.pageNo==0} onClick={()=>this.getTakmicenja(this.state.pageNo-1)}>
                        Previous
                    </Button>
                    <Button
                        disabled={this.state.pageNo==this.state.totalPages-1} onClick={()=>this.getTakmicenja(this.state.pageNo+1)}>
                        Next
                    </Button>
                    <Button 
                      variant="success"
                       onClick={() => this.goToAdd()}
                        style={{ marginLeft: 5 }}
                     >
                     Kreiraj takmicenje
                    </Button>

                    </ButtonGroup>

                  <Table bordered striped style={{ marginTop: 5 }}>
                    <thead className="thead-dark">
                        <tr>
                        <th>Naziv</th>
                        <th>Mesto</th>
                        <th>Datum pocetka</th>
                        <th>Datum zavrsetka</th>
                        <th>Format</th>
                        <th colSpan={2}>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.takmicenja.map((takmicenja) => {
                        return (
                            <tr key={takmicenja.id}>
                            <td>{takmicenja.naziv}</td>
                            <td>{takmicenja.mesto}</td>
                            <td>{takmicenja.datumPocetka}</td>
                            <td>{takmicenja.datumZavrsetka}</td>
                            <td>{takmicenja.formatTip}</td>
                            <td>
                            <Button
                                variant="danger"
                                onClick={() => this.doDelete(takmicenja.id)}
                                style={{ marginLeft: 5 }}
                                >
                                Delete
                            </Button>
                            <Button
                                variant="info"
                                onClick={() => this.prijava(takmicenja.id)}
                                style={{ marginLeft: 5 }}
                                >
                                Prijavi se
                            </Button>
                            </td>
                            </tr>
                          );
                        })}
                    </tbody>
                 </Table>
                </div>

            )
        }
    }

    export default Takmicenja;