import React, { Component } from 'react'
import UserService from '../services/UserService'

export default class ListUsers extends Component {
    constructor(props) {
        super(props)

        this.state = {
            users: [],
            phones: [],
            done: false
        }
        this.editUser = this.editUser.bind(this);
        this.deleteUser = this.deleteUser.bind(this);
    }

    componentDidMount(){
        UserService.getUsers().then((res) => {
            this.setState({ users: res.data.sort((a, b) => (a.id > b.id) ? 1 : -1)});
            res.data.map(
                user => UserService.getUserPhones(user.id).then((res) => {
                    let phones = [...this.state.phones];
                    let numbers = [];
                    res.data.map(phone => numbers.push(phone.phone));
                    phones[user.id] = numbers;
                    this.setState({ phones: phones});
                })
            )
        });        
        this.setState({ done: true});
    }

    editUser(id) {
        this.props.history.push(`/edit/${id}`);
    }

    deleteUser(id) {
        UserService.deleteUser(id).then((res) => {
            this.setState({ users: this.state.users.filter(user => user.id !== id)});
        });
    }

    render() {
        return (
            <div className="text-center">
                <div className="row">
                    <table className="table table-striped table-bordered">
                        <thead>
                            <tr>
                                <th> ID </th>
                                <th> Name </th>
                                <th> E-mail </th>
                                <th> Birthday </th>
                                <th> City </th>
                                <th> Phone </th>
                                <th> Options </th>
                            </tr>
                        </thead>
                        <tbody>
                            {       this.state.done ?                          
                                        this.state.users.map(
                                            user =>
                                            <tr key = {user.id}>
                                                <td> {user.id} </td>
                                                <td> {user.name} </td>
                                                <td> {user.email} </td>
                                                <td> {user.birthday} </td>
                                                <td> {user.city} </td>
                                                <td> {this.state.phones.map((phone,index) => (index === user.id ? phone ? (phone.map(number => <div key={user.id + "-" + number} >{number}</div>)): <div key={index}></div> : <div key={index}></div>))} </td>
                                                <td className="d-flex justify-content-around">                                            
                                                    <button className="btn btn-primary" onClick={() => this.editUser(user.id)}>Edit</button>
                                                    <button className="btn btn-danger" onClick={() => this.deleteUser(user.id)}>Delete</button>
                                                </td>
                                            </tr>
                                        )
                                    : <div></div>
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}
