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
            phones: [""],
            password: ""
        }

        this.changeInfoHandler = this.changeInfoHandler.bind(this);
        this.changePhoneHandler = this.changePhoneHandler.bind(this);
        this.saveUser = this.saveUser.bind(this);
        this.savePhone = this.savePhone.bind(this);
    }

    changeInfoHandler = (event) => {
        this.setState({[event.target.id]: event.target.value});
    }

    changePhoneHandler = (event) => {
        let phonesCopy = this.state.phones.slice();
        phonesCopy[event.target.id] = event.target.value;
        if(phonesCopy.length === parseInt(event.target.id) + 1){
            phonesCopy.push("");
        }
        this.setState({phones: phonesCopy});
    }

    savePhone = (event) => {
        event.preventDefault();
        let phone = { phone: event.target.value};
        UserService.createPhone(phone).then((resp) => {
            console.log(resp.data);
        });
    }

    saveUser = (event) => {
        event.preventDefault();
        // console.log(JSON.stringify(this.state));
        
        let user = {name: this.state.name, email: this.state.email, birthday: this.state.birthday, city: this.state.city, password: this.state.password};

        UserService.createUser(user).then((res) => {
            this.state.phones.map(phoneNumber => phoneNumber ? (UserService.createPhone({phone: phoneNumber}).then((resp) => {
                UserService.addPhoneToUser(resp.data.id, res.data.id).then((respo)=> {
                });
            })) : null);

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
                                            <div>
                                                {/* <span className="input-group-addon">
                                                    <i className="fa fa-envelope fa" aria-hidden="true"></i>
                                                </span> 
                                                <input defaultValue={this.state.phone} type="text" className="form-control" name="phone" id="phone" placeholder="Enter your phone number" onBlur={this.changeInfoHandler} />*/}
                                                {this.state.phones.map((phone, index) => <input key={"phone"+index}  defaultValue={this.state.phones[index]} type="text" className="form-control mb-1" name={"phone"+index} id={index} placeholder="Enter your phone number" onBlur={this.changePhoneHandler} />)}
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
