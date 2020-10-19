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
// import { useTable } from "react-table";
// import ReactTable from "react-table-6";  
// import "react-table-6/react-table.css" 



class Summary extends Component {
  email= "ad1231@markallen.com";

  constructor (props) {
    super(props);
    this.state = {
      // rows : [],
      isLoading : true,
      rows:[{
        id: String,
        eid: String,
        endDate: "",
        timesheet: { day1:{day:String, date:String, startTime:String, endTime: String, hours:Number, floating: Boolean, holiday:Boolean, vaction:Boolean},
                     day2:{day:String, date:String, startTime:String, endTime: String, hours:Number, floating: Boolean, holiday:Boolean, vaction:Boolean},
                     day3:{day:String, date: String, startTime:String, endTime: String, hours:Number, floating: Boolean, holiday:Boolean, vaction:Boolean}, 
                     day4:{day:String, date: String, startTime:String, endTime: String, hours:Number, floating: Boolean, holiday:Boolean, vaction:Boolean}, 
                     day5:{day:String, date: String, startTime:String, endTime: String, hours:Number, floating: Boolean, holiday:Boolean, vaction:Boolean}, 
                     day6:{day:String, date: String, startTime:String, endTime: String, hours:Number, floating: Boolean, holiday:Boolean, vaction:Boolean}, 
                     day7:{day:String, date: String, startTime:String, endTime: String, hours:Number, floating: Boolean, holiday:Boolean, vaction:Boolean}},
        billingHours: Number,
        totalHours: Number,
        overtimeHours: Number,
        submissionStatus: "",
        approveStatus: String,
        comment: String,
        files: String,
        defaultTimesheet: Boolean
      }]
    }
  }

componentDidMount() {
  axios.get(`http://localhost:8080/getAllTimesheets?email=`+this.email)
    .then(res => {
      const row1 = res.data;
      console.log(res.data);
      this.setState({row1});
      this.setState({ isLoading: false });
      console.log(row1);
      console.log(this.state.rows.length);
    })
}


  render() {
    // const {tableData} = this.state;
    if (this.state.isLoading) {
      return <div>Loading...</div>;
    }
    return (
      <div>
        <h2>TimeSheeet Summary</h2>
            <div>
              <span>Week Endinng</span>
              <span>Total Hours</span>
              <span>Submission Status</span>
            </div>
            {this.state.rows.map((row)=>(
            <div key = {row.id}>
              <span> {row.endDate}</span>
              <span> {row.totalHours}</span>
              <span> {row.submissionStatus}</span>
            </div>))}
      </div>
  );
  }
}

export default Summary;