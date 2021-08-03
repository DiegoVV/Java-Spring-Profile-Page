import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
// import App from "./App";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import reportWebVitals from "./reportWebVitals";
import "bootstrap/dist/css/bootstrap.min.css";
import ListUsers from "./components/ListUsers";
import UserProfile from "./components/UserProfile";
import CreateUser from "./components/CreateUser";
import EditUser from "./components/EditUser";
import Login from "./components/Login";

ReactDOM.render(
    <React.StrictMode>
        <Router>
			<Switch>
				<Route exact={true} path = "/" component={Login} ></Route>
				<Route path = "/profile/:id" component={UserProfile} ></Route>
				<Route path = "/signup" component={CreateUser} ></Route>
				<Route path = "/edit/:id" component={EditUser} ></Route>
				<Route path = "/list" component={ListUsers} ></Route>
			</Switch>
            {/* <App /> */}
        </Router>
    </React.StrictMode>,
    document.getElementById("root")
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
