import React, { Component } from 'react';
import axios from 'axios'

class TimeSheeet extends Component {

  email = "ad1231@markallen.com";
  endDate = "10-10-2020"
  constructor(props) {
    super(props);

    this.state = {
      isLoading: true,
      timesheets:{
        id: String,
        eid: String,
        endDate: String,
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
        submissionStatus: String,
        approveStatus: String,
        comment: String,
        files: String,
        defaultTimesheet: Boolean
      }
    };

   // this.handleInputChange = this.handleInputChange.bind(this);
  }
  

componentDidMount() {
  console.log("Comp Mounted")
  axios.get(`http://localhost:8802/getSingleTimesheet?endDate=`+this.endDate+`&email=`+this.email)
     .then(res => {
       this.setState({timesheets: res.data});
       this.setState({ isLoading: false });
       console.log(this.state.timesheets)
      })
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });

    console.log(this.state.timesheets.timesheet.day1.endTime)
  }

  render() {
    if (this.state.isLoading) {
      return <div>Loading...</div>;
    }

    return (
        <div>
          <h2>TimeSheeet</h2>
          <div>
            <label>Week Ending: </label>
            <input value={this.state.timesheets.endDate} disabled='true'></input>
          </div>
          <div>
            <label>Total Billing Hours:</label>
            <input value={this.state.timesheets.billingHours} disabled='true'></input>
          </div>
          <div>
            <label>Total Compensated Hours:</label>
            <input value={this.state.timesheets.totalHours} disabled='true'></input>
          </div>

          <table>
            <thead>
              <tr>
                <td>Day</td>
                <td>Date</td>
                <td>Starting Time</td>
                <td>Ending Time</td>
                <td>Total Hours</td>
                <td>Floating Day</td>
                <td>Holiday</td>
                <td>Vacation</td>
              </tr>
            </thead>
            <tbody>
              <tr>
                <td>{this.state.timesheets.timesheet.day1.day}</td>
                <td><input value={this.state.timesheets.timesheet.day1.date} disabled='true'></input></td>
                <td><input value= {this.state.timesheets.timesheet.day1.startTime} onChange={this.handleChange}></input></td>
                <td><input value={this.state.timesheets.timesheet.day1.endTime} onChange={this.handleChange}></input></td>
                <td><input value={this.state.timesheets.timesheet.day1.hours} onChange={this.handleChange}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day1.floating} onChange={this.handleChange}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day1.holiday} onChange={this.handleChange}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day1.vaction} onChange={this.handleChange}></input></td>  
              </tr>
              <tr>
                <td> {this.state.timesheets.timesheet.day2.day}</td>
                <td><input value= {this.state.timesheets.timesheet.day2.date} disabled='true'></input></td>
                <td><input value={this.state.timesheets.timesheet.day2.startTime} onChange={this.handleChange}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day2.endTime} onChange={this.handleChange}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day2.hours} onChange={this.handleChange}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day2.floating} onChange={this.handleChange}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day2.holiday} onChange={this.handleChange}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day2.vaction} onChange={this.handleChange}></input></td>  
              </tr>
              <tr>
                <td> {this.state.timesheets.timesheet.day3.day}</td>
                <td><input value={this.state.timesheets.timesheet.day3.date} disabled='true'></input></td>
                <td><input value={this.state.timesheets.timesheet.day3.startTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day3.endTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day3.hours}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day3.floating}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day3.holiday}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day3.vaction}></input></td>  
              </tr>
              <tr>
                <td> {this.state.timesheets.timesheet.day4.day}</td>
                <td><input value= {this.state.timesheets.timesheet.day4.date} disabled='true'></input></td>
                <td><input value={this.state.timesheets.timesheet.day4.startTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day4.endTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day4.hours}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day4.floating}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day4.holiday}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day4.vaction}></input></td>  
              </tr>
              <tr>
                <td> {this.state.timesheets.timesheet.day5.day}</td>
                <td><input value= {this.state.timesheets.timesheet.day5.date} disabled='true'></input></td>
                <td><input value={this.state.timesheets.timesheet.day5.startTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day5.endTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day5.hours}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day5.floating}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day5.holiday}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day5.vaction}></input></td>  
              </tr>
              <tr>
                <td> {this.state.timesheets.timesheet.day6.day}</td>
                <td><input value= {this.state.timesheets.timesheet.day6.date} disabled='true'></input></td>
                <td><input value={this.state.timesheets.timesheet.day6.startTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day6.endTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day6.hours}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day6.floating}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day6.holiday}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day6.vaction}></input></td>  
              </tr>
              <tr>
                <td> {this.state.timesheets.timesheet.day7.day}</td>
                <td><input value={this.state.timesheets.timesheet.day7.date} disabled='true'></input></td>
                <td><input value={this.state.timesheets.timesheet.day7.startTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day7.endTime}></input></td>
                <td><input value= {this.state.timesheets.timesheet.day7.hours}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day7.floating}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day7.holiday}></input></td>
                <td><input type="radio" value={this.state.timesheets.timesheet.day7.vaction}></input></td>  
              </tr>
            
            </tbody>
          </table>

          <div>
            <label>Upload Timesheet:  </label>
            <input type="file"></input>
          </div>
          <button type='submit'>Save</button>
        </div>
    );
  }
}

export default TimeSheeet;