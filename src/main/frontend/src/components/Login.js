import React, { Component } from "react";
import UserService from "../services/UserService";

export default class Login extends Component {
    constructor(props) {
        super(props);

        this.state = {
            email: "",
            password: ""
        };

        this.changeInfoHandler = this.changeInfoHandler.bind(this);
        this.loginUser = this.loginUser.bind(this);
    }

    changeInfoHandler = (event) => {
        this.setState({[event.target.id]: event.target.value});
    }

    loginUser = (event) => {
        event.preventDefault();

        UserService.loginUser(this.state.email, this.state.password).then((res) => {
            if(res.data > 0){
                this.props.history.push('/profile/'+ res.data);
            } else if (res.data === 0){
                this.props.history.push('/list');
            } else {
                alert("wrong email or password");
            }
        });
    }

    render() {
        return (
            <div className="container col-sm-3">
                <div className="main-body">
                    <div className="row gutters-sm">
                        <div className="card">
                            <form>
                                <h3>Sign In</h3>

                                <div className="form-group">
                                    <label>Email address</label>
                                    <input id="email" type="email" className="form-control" placeholder="Enter email" onBlur={this.changeInfoHandler} />
                                </div>

                                <div className="form-group">
                                    <label>Password</label>
                                    <input id="password" type="password" className="form-control" placeholder="Enter password" onBlur={this.changeInfoHandler} />
                                </div>

                                <div className="form-group">
                                    <div className="custom-control custom-checkbox">
                                        <input type="checkbox" className="custom-control-input" id="customCheck1" />
                                        <label className="custom-control-label" htmlFor="customCheck1">
                                            Remember me
                                        </label>
                                    </div>
                                    <p className="forgot-password text-right">
                                        Forgot <a href="/#">password?</a>
                                    </p>
                                </div>

                                <button type="submit" className="btn btn-primary btn-block" onClick={this.loginUser}>
                                    Submit
                                </button>
                            </form>
                            <p className="text-center mb-0 mt-3">
                                New user?
                            </p>
                            <a className="text-center font-weight-bold mb-3" href="/signup">
                                SIGN UP
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}
