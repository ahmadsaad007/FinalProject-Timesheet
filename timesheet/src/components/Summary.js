import React, { Component } from 'react';
// import ReactDOM from 'react-dom';
// import { makeStyles } from '@material-ui/core/styles';
// import Table from '@material-ui/core/Table';
// import TableBody from '@material-ui/core/TableBody';
// import TableCell from '@material-ui/core/TableCell';
// import TableContainer from '@material-ui/core/TableContainer';
// import TableHead from '@material-ui/core/TableHead';
// import TableRow from '@material-ui/core/TableRow';
// import Paper from '@material-ui/core/Paper';
import axios from 'axios';
import { Table } from 'react-bootstrap';
import { Link } from 'react-router-dom';

// import { useTable } from "react-table";
// import ReactTable from "react-table-6";  
// import "react-table-6/react-table.css" 



class Summary extends Component {
  email= "ad1231@markallen.com";

  state = {
    timeList:[]
  };
 
componentDidMount() {
  axios.get(`http://localhost:8080/getAllTimesheets?email=`+this.email)
    .then(res => {
      console.log(res.data)
      this.setState({timeList: res.data})
    })
}


  render() {
    const tableRows = () => {
      return this.state.timeList.map((person) => {
        return (
          <tr key={person.endDate}>
            <td>{person.endDate}</td>
            <td>{person.totalHours}</td>
            <td>{person.submissionStatus}</td>
            <td>{person.approveStatus}</td>
            <td>
              {' '}
              <Link to={`/timesheet/${person.endDate}`}>
                {person.approvedStatus === 'Approved' ? 'Edit' : 'View'}
              </Link>
            </td>
            <td>{person.comment}</td>
          </tr>
        );
      });
    };

    return (
      <Table striped bordered hover>
              <thead>
                <tr>
                  <th>WeekEnding</th>
                  <th>TotalHours</th>
                  <th>SubmissionStatus</th>
                  <th>ApprovalStatus</th>
                  <th>Option</th>
                  <th>Comments</th>
                </tr>
              </thead>
              <tbody>{tableRows()}</tbody>
            </Table>
    )
  }
}

export default Summary;