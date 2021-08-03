import React, { Component } from "react";
import UserService from "../services/UserService";

export default class CreateUser extends Component {
    constructor(props){
        super(props)

        this.state = {
            id: window.location.pathname.substring(window.location.pathname.lastIndexOf('/') + 1),
            user: {}
        }

        this.changeInfoHandler = this.changeInfoHandler.bind(this);
        this.updateUser = this.updateUser.bind(this);
    }
    
    componentDidMount(){
        UserService.getUser(this.state.id).then((res) => {
            this.setState({ user: res.data});
        });
    }

    changeInfoHandler = (event) => {
        this.setState(prevState => {
            let user = Object.assign({}, prevState.user);  // creating copy of state variable jasper
            user[event.target.id] = event.target.value;                     // update the name property, assign a new value                 
            return { user };                                 // return new object jasper object
          })
    }

    updateUser = (event) => {
        event.preventDefault();
        // console.log(JSON.stringify(this.state));
        UserService.updateUser(this.state.id, this.state.user).then((res) => {
            this.props.history.push('/profile/' + this.state.id);
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
                                                <input defaultValue={this.state.user.name} type="text" className="form-control" name="name" id="name" placeholder="Enter your name" onBlur={this.changeInfoHandler} />
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
                                                <input defaultValue={this.state.user.email} type="text" className="form-control" name="email" id="email" placeholder="Enter your email" onBlur={this.changeInfoHandler} />
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
                                                <input defaultValue={this.state.user.city} type="text" className="form-control" name="city" id="city" placeholder="Enter the city you live in" onBlur={this.changeInfoHandler} />
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
                                                <input defaultValue={this.state.user.phone} type="text" className="form-control" name="phone" id="phone" placeholder="Enter your phone number" onBlur={this.changeInfoHandler} />
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
                                                <input defaultValue={this.state.user.birthday} type="date" className="form-control" name="birthday" id="birthday" placeholder="Enter your birthday" onBlur={this.changeInfoHandler} />
                                            </div>
                                        </div>
                                    </div>
                                    <div className="form-group ">
                                        <button type="button" className="btn btn-primary btn-lg btn-block login-button" onClick={this.updateUser}>
                                            Update
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
