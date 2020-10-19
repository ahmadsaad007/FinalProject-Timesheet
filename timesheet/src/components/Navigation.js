import React, { Component } from 'react'
import { BrowserRouter as Router, Switch, Route, Link } from 'react-router-dom';
import Profile from './Profile';
import TimeSheet from './TimeSheet';
import Summary from './Summary';

export default class Navigation extends Component {
    state = {
        show: true,
    };
    render() {
        const show = this.state.show;
        return (
            <Router>
            <div className="container">
                <ul className="nav nav-tabs" id="myTab" role="tablist">
                <li className="nav-item" role="presentation">
                    <Link to={'/'} className="nav-link"> Summary </Link>
                    {/* <a class="nav-link active" id="Summary-tab" data-toggle="tab" href="#Summary" role="tab" aria-controls="Summary" aria-selected="true">Summary</a> */}
                </li>
                {show && <li className="nav-item" role="presentation">
                    <Link to={'/timesheet'} className="nav-link">TimeSheet</Link>
                    {/* <a class="nav-link" id="TimeSheet-tab" data-toggle="tab" href="#TimeSheet" role="tab" aria-controls="TimeSheet" aria-selected="false">TimeSheet</a> */}
                </li>}
                <li className="nav-item" role="presentation">
                    <Link to={'/profile'} className="nav-link">Profile</Link>
                    {/* <a class="nav-link" id="Profile-tab" data-toggle="tab" href="#Profile" role="tab" aria-controls="Profile" aria-selected="false">Profile</a> */}
                </li>
                </ul>
                <Switch>
                    <Route exact path='/' component={Summary} />
                    <Route path='/timesheet/:time' component={TimeSheet} />
                    <Route path='/profile' component={Profile} />
                </Switch>
                {/* <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="Summary" role="tabpanel" aria-labelledby="Summary-tab">...</div>
                    <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">...</div>
                    <div class="tab-pane fade" id="contact" role="tabpanel" aria-labelledby="contact-tab">...</div>
                </div>     */}
            </div>
            </Router>
        )
    }
}
