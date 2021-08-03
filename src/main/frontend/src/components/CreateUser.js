import React, { Component } from "react";
import UserService from "../services/UserService";

export default class CreateUser extends Component {
    constructor(props){
        super(props)

        this.state = {
            name: "",
            email: "",
            birthday: "",
            city: "",
            phone: "",
            password: ""
        }

        this.changeInfoHandler = this.changeInfoHandler.bind(this);
        this.saveUser = this.saveUser.bind(this);
    }

    changeInfoHandler = (event) => {
        this.setState({[event.target.id]: event.target.value});
    }

    saveUser = (event) => {
        event.preventDefault();
        // console.log(JSON.stringify(this.state));

        UserService.createUser(this.state).then((res) => {
            this.props.history.push('/profile/' + res.data.id);
        });
    }

    render() {
        return (
            <div className="container">
                <div className="row justify-content-center">
                    <div className="col-md-8">
                        <div className="card">
                            <div className="card-body">
                                <form className="form-horizontal" method="post" action="#">
                                    <div className="form-group">
                                        <label htmlFor="name" className="cols-sm-2 control-label">
                                            Name
                                        </label>
                                        <div className="cols-sm-10">
                                            <div className="input-group">
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-user fa" aria-hidden="true"></i>
                                                </span> */}
                                                <input defaultValue={this.state.name} type="text" className="form-control" name="name" id="name" placeholder="Enter your name" onBlur={this.changeInfoHandler} />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="email" className="cols-sm-2 control-label">
                                            Email
                                        </label>
                                        <div className="cols-sm-10">
                                            <div className="input-group">
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-envelope fa" aria-hidden="true"></i>
                                                </span> */}
                                                <input defaultValue={this.state.email} type="text" className="form-control" name="email" id="email" placeholder="Enter your email" onBlur={this.changeInfoHandler} />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="city" className="cols-sm-2 control-label">
                                            City
                                        </label>
                                        <div className="cols-sm-10">
                                            <div className="input-group">
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-envelope fa" aria-hidden="true"></i>
                                                </span> */}
                                                <input defaultValue={this.state.city} type="text" className="form-control" name="city" id="city" placeholder="Enter the city you live in" onBlur={this.changeInfoHandler} />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="phone" className="cols-sm-2 control-label">
                                            Phone
                                        </label>
                                        <div className="cols-sm-10">
                                            <div className="input-group">
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-envelope fa" aria-hidden="true"></i>
                                                </span> */}
                                                <input defaultValue={this.state.phone} type="text" className="form-control" name="phone" id="phone" placeholder="Enter your phone number" onBlur={this.changeInfoHandler} />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="birthday" className="cols-sm-2 control-label">
                                            Birthday
                                        </label>
                                        <div className="cols-sm-10">
                                            <div className="input-group">
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-users fa" aria-hidden="true"></i>
                                                </span> */}
                                                <input defaultValue={this.state.birthday} type="date" className="form-control" name="birthday" id="birthday" placeholder="Enter your birthday" onBlur={this.changeInfoHandler} />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="password" className="cols-sm-2 control-label">
                                            Password
                                        </label>
                                        <div className="cols-sm-10">
                                            <div className="input-group">
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-lock fa-lg" aria-hidden="true"></i>
                                                </span> */}
                                                <input type="password" className="form-control" name="password" id="password" placeholder="Enter your password" onBlur={this.changeInfoHandler} />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group">
                                        <label htmlFor="confirm" className="cols-sm-2 control-label">
                                            Confirm Password
                                        </label>
                                        <div className="cols-sm-10">
                                            <div className="input-group">
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-lock fa-lg" aria-hidden="true"></i>
                                                </span> */}
                                                <input type="password" className="form-control" name="confirm" id="confirm" placeholder="Confirm your password" />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group ">
                                        <button type="button" className="btn btn-primary btn-lg btn-block login-button" onClick={this.saveUser}>
                                            Register
                                        </button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
