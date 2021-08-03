import React, { Component } from "react";
import UserService from '../services/UserService'

export default class UserProfile extends Component {
    constructor(props) {
        super(props);

        this.state = {
            id: window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1),
            user: {

            },
            phones: []
        };
    }
    
    componentDidMount(){
        UserService.getUser(this.state.id).then((res) => {
            this.setState({ user: res.data});
        });
        UserService.getUserPhones(this.state.id).then((res) => {
            let numbers = [];
            res.data.map(phone => numbers.push(phone.phone));
            this.setState({ phones: numbers});
        });
    }


    render() {
        let today = new Date();

        return (
            <div className="container">
                <div className="main-body">
                    <div className="row gutters-sm">
                        <div className="card">
                            <div className="card-body">
                                <div className="d-flex flex-column align-items-center text-center">
                                    <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" className="rounded-circle avatar" width="150" />
                                    <div className="mt-3">
                                        <h4>
                                            {this.state.user.name}, {today.getFullYear() - new Date(this.state.user.birthday).getFullYear()}
                                        </h4>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div className="card mb-3 text-center">
                            <div className="card-body">
                                <div className="row">
                                    <div className="col-sm-6">
                                        <h6 className="mb-0">Full Name</h6>
                                    </div>
                                    <div className="col-sm-6 text-secondary">{this.state.user.name}</div>
                                </div>
                                <hr />
                                <div className="row">
                                    <div className="col-sm-6">
                                        <h6 className="mb-0">Email</h6>
                                    </div>
                                    <div className="col-sm-6 text-secondary">{this.state.user.email}</div>
                                </div>
                                <hr />
                                <div className="row">
                                    <div className="col-sm-6">
                                        <h6 className="mb-0">Phone</h6>
                                    </div>
                                    <div className="col-sm-6 text-secondary">
                                        {                                
                                            this.state.phones.map(
                                                phone =>
                                                <div key = {phone}>
                                                    {phone}
                                                </div>
                                            )
                                        }
                                    </div>
                                </div>
                                <hr />
                                <div className="row">
                                    <div className="col-sm-6">
                                        <h6 className="mb-0">City</h6>
                                    </div>
                                    <div className="col-sm-6 text-secondary">{this.state.user.city}</div>
                                </div>
                                <hr />
                                <div className="row">
                                    <div className="col-sm-12">
                                        <a className="btn btn-info " target="__blank" href={"/edit/" + this.state.id}>
                                            Edit
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
