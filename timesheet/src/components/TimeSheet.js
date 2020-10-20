import React, { Component } from "react";
import axios from "axios";
import DayComponent from "./DayComponent";

class TimeSheeet extends Component {
  email = "ad1231@markallen.com";
  endDate = "10-10-2020";
  constructor(props) {
    super(props);
    this.state = {
      isLoading: true,
      timesheetsId: String,
      eid: String,
      endDate: String,
      files: String,

      day1: String,
      date1: String,
      startTime1: String,
      endTime1: String,
      hours1: Number,
      floating1: Boolean,
      holiday1: Boolean,
      vacation1: Boolean,

      day2: String,
      date2: String,
      startTime2: String,
      endTime2: String,
      hours2: Number,
      floating2: Boolean,
      holiday2: Boolean,
      vacation2: Boolean,

      day3: String,
      date3: String,
      startTime3: String,
      endTime3: String,
      hours3: Number,
      floating3: Boolean,
      holiday3: Boolean,
      vacation3: Boolean,

      day4: String,
      date4: String,
      startTime4: String,
      endTime4: String,
      hours4: Number,
      floating4: Boolean,
      holiday4: Boolean,
      vacation4: Boolean,

      day5: String,
      date5: String,
      startTime5: String,
      endTime5: String,
      hours5: Number,
      floating5: Boolean,
      holiday5: Boolean,
      vacation5: Boolean,

      day6: String,
      date6: String,
      startTime6: String,
      endTime6: String,
      hours6: Number,
      floating6: Boolean,
      holiday6: Boolean,
      vacation6: Boolean,

      day7: String,
      date7: String,
      startTime7: String,
      endTime7: String,
      hours7: Number,
      floating7: Boolean,
      holiday7: Boolean,
      vacation7: Boolean,

      billingHours: Number,
      totalHours: Number,
      overtimeHours: Number,
      submissionStatus: String,
      approveStatus: String,
      comment: String,
      defaultTimesheet: Boolean,
    };

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount() {
    var time = this.props.match.params.time+"";
    if (time.length == 0){
       time = this.endDate;
    }
  
  console.log(time.length);
  axios.get(`http://localhost:8080/getSingleTimesheet?endDate=`+time+`&email=`+this.email).then((res) => {
        var {
          timesheetsId,
          eid,
          endDate,
          timesheet,
          billingHours,
          totalHours,
          overtimeHours,
          submissionStatus,
          approveStatus,
          comment,
          files,
          defaultTimesheet,
        } = res.data;

        var day1 = timesheet.day1.day;
        var date1 = timesheet.day1.date;
        var startTime1 = timesheet.day1.startTime;
        var endTime1 = timesheet.day1.endTime;
        var hours1 = timesheet.day1.hours;
        var floating1 = timesheet.day1.floating;
        var holiday1 = timesheet.day1.holiday;
        var vacation1 = timesheet.day1.vacation;

        var day2 = timesheet.day2.day;
        var date2 = timesheet.day2.date;
        var startTime2 = timesheet.day2.startTime;
        var endTime2 = timesheet.day2.endTime;
        var hours2 = timesheet.day2.hours;
        var floating2 = timesheet.day2.floating;
        var holiday2 = timesheet.day2.holiday;
        var vacation2 = timesheet.day2.vacation;

        var day3 = timesheet.day3.day;
        var date3 = timesheet.day3.date;
        var startTime3 = timesheet.day3.startTime;
        var endTime3 = timesheet.day3.endTime;
        var hours3 = timesheet.day3.hours;
        var floating3 = timesheet.day3.floating;
        var holiday3 = timesheet.day3.holiday;
        var vacation3 = timesheet.day3.vacation;

        var day4 = timesheet.day4.day;
        var date4 = timesheet.day4.date;
        var startTime4 = timesheet.day4.startTime;
        var endTime4 = timesheet.day4.endTime;
        var hours4 = timesheet.day4.hours;
        var floating4 = timesheet.day4.floating;
        var holiday4 = timesheet.day4.holiday;
        var vacation4 = timesheet.day4.vacation;

        var day5 = timesheet.day5.day;
        var date5 = timesheet.day5.date;
        var startTime5 = timesheet.day5.startTime;
        var endTime5 = timesheet.day5.endTime;
        var hours5 = timesheet.day5.hours;
        var floating5 = timesheet.day5.floating;
        var holiday5 = timesheet.day5.holiday;
        var vacation5 = timesheet.day5.vacation;

        var day6 = timesheet.day6.day;
        var date6 = timesheet.day6.date;
        var startTime6 = timesheet.day6.startTime;
        var endTime6 = timesheet.day6.endTime;
        var hours6 = timesheet.day6.hours;
        var floating6 = timesheet.day6.floating;
        var holiday6 = timesheet.day6.holiday;
        var vacation6 = timesheet.day6.vacation;

        var day7 = timesheet.day7.day;
        var date7 = timesheet.day7.date;
        var startTime7 = timesheet.day7.startTime;
        var endTime7 = timesheet.day7.endTime;
        var hours7 = timesheet.day7.hours;
        var floating7 = timesheet.day7.floating;
        var holiday7 = timesheet.day7.holiday;
        var vacation7 = timesheet.day7.vacation;

        this.setState({
          timesheetsId,
          eid,
          endDate,
          billingHours,
          totalHours,
          overtimeHours,
          submissionStatus,
          approveStatus,
          comment,
          files,
          defaultTimesheet,

          day1,
          date1,
          startTime1,
          endTime1,
          hours1,
          floating1,
          holiday1,
          vacation1,

          day2,
          date2,
          startTime2,
          endTime2,
          hours2,
          floating2,
          holiday2,
          vacation2,

          day3,
          date3,
          startTime3,
          endTime3,
          hours3,
          floating3,
          holiday3,
          vacation3,

          day4,
          date4,
          startTime4,
          endTime4,
          hours4,
          floating4,
          holiday4,
          vacation4,

          day5,
          date5,
          startTime5,
          endTime5,
          hours5,
          floating5,
          holiday5,
          vacation5,

          day6,
          date6,
          startTime6,
          endTime6,
          hours6,
          floating6,
          holiday6,
          vacation6,

          day7,
          date7,
          startTime7,
          endTime7,
          hours7,
          floating7,
          holiday7,
          vacation7
        });

        this.setState({ isLoading: false });

        //console.log(this.state);
      });


  handleChange(event) {
    this.setState({ [event.target.name]: event.target.value });

    console.log(event.target.name);
    console.log(event.target.value);
  }

  handleSubmit(event) {
    console.log(this.state.startTime1)
    const obj = [

      this.state.timesheetsId,//0
      this.state.eid,
      this.state.endDate,//2
      this.state.billingHours,//3
      this.state.totalHours,//4
      this.state.overtimeHours,//5
      this.state.submissionStatus,//6
      this.state.approveStatus,
      this.state.comment,//8
      this.state.files,
      this.state.defaultTimesheet,

      this.state.day1,//11
      this.state.date1,//12
      this.state.startTime1,//13
      this.state.endTime1,
      this.state.hours1,//15
      this.state.floating1,
      this.state.holiday1,
      this.state.vacation1,//18

      this.state.day2,//19
      this.state.date2,
      this.state.startTime2,//21
      this.state.endTime2,
      this.state.hours2,//23
      this.state.floating2,
      this.state.holiday2,
      this.state.vacation2,//26

      this.state.day3,//27
      this.state.date3,//28
      this.state.startTime3,//29
      this.state.endTime3,
      this.state.hours3,
      this.state.floating3,
      this.state.holiday3,
      this.state.vacation3,

      this.state.day4,
      this.state.date4,
      this.state.startTime4,
      this.state.endTime4,
      this.state.hours4,
      this.state.floating4,
      this.state.holiday4,
      this.state.vacation4,

      this.state.day5,
      this.state.date5,
      this.state.startTime5,
      this.state.endTime5,
      this.state.hours5,
      this.state.floating5,
      this.state.holiday5,
      this.state.vacation5,

      this.state.day6,
      this.state.date6,
      this.state.startTime6,
      this.state.endTime6,
      this.state.hours6,
      this.state.floating6,
      this.state.holiday6,
      this.state.vacation6,

      this.state.day7,
      this.state.date7,
      this.state.startTime7,
      this.state.endTime7,
      this.state.hours7,
      this.state.floating7,
      this.state.holiday7,
      this.state.vacation7
    ];

    axios.post('http://localhost:8802/updateTimesheet?obj=' + obj + '&email=' + this.email).then(res => {
      console.log(res);
      console.log(res.data);
      alert("Timesheet Successfully Updated")
    }).catch(error => { alert("An error occurred! Try again!") })
    event.preventDefault();
  }

  render() {
    if (this.state.isLoading) {
      return <div>Loading...</div>;
    }

    return (
      <div>
        <h2>TimeSheeet</h2>

        <div style={{ paddingLeft: '15%', paddingRight: '15%' }}>
          <span style={{ float: 'left' }}>
            <label style={{ paddingRight: '40px' }}>Week Ending: </label>
            <input
              defaultValue={this.state.endDate}
              onChange={(e) => this.handleChange(e)}
              disabled={true}
            ></input>
          </span>
          <span style={{ float: 'right' }}>
            <button>Set Default</button>
          </span>
        </div>

        <div style={{ marginTop: '50px', paddingLeft: '15%', paddingRight: '15%' }}>
          <span style={{ float: 'left' }}>
            <label style={{ paddingRight: '5px' }}>Total Billing Hours:</label>
            <input
              value={this.state.billingHours}
              disabled={true}
            ></input>
          </span>
          <span style={{ float: 'right' }}>
            <label>Total Compensated Hours:</label>
            <input
              value={this.state.totalHours}
              disabled={true}
            ></input>
          </span>
        </div>

        <table style={{ marginTop: '15%' }}>
          <thead>
            <tr style={{ fontSize: '16px', fontWeight: 'bold' }}>
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
            <DayComponent
              date={this.state.date1}
              day={this.state.day1}
              startTime={this.state.startTime1}
              endTime={this.state.endTime1}
              hours={this.state.hours1}
              floating={this.state.floating1}
              holiday={this.state.holiday1}
              vacation={this.state.vacation1}
              index="1"
              handleChange={this.handleChange}
            />
            <DayComponent
              date={this.state.date2}
              day={this.state.day2}
              startTime={this.state.startTime2}
              endTime={this.state.endTime2}
              hours={this.state.hours2}
              floating={this.state.floating2}
              holiday={this.state.holiday2}
              vacation={this.state.vacation2}
              index="2"
              handleChange={this.handleChange}
            />

            <DayComponent
              date={this.state.date3}
              day={this.state.day3}
              startTime={this.state.startTime3}
              endTime={this.state.endTime3}
              hours={this.state.hours3}
              floating={this.state.floating3}
              holiday={this.state.holiday3}
              vacation={this.state.vacation3}
              index="3"
              handleChange={this.handleChange}
            />

            <DayComponent
              date={this.state.date4}
              day={this.state.day4}
              startTime={this.state.startTime4}
              endTime={this.state.endTime4}
              hours={this.state.hours4}
              floating={this.state.floating4}
              holiday={this.state.holiday4}
              vacation={this.state.vacation4}
              index="4"
              handleChange={this.handleChange}
            />

            <DayComponent
              date={this.state.date5}
              day={this.state.day5}
              startTime={this.state.startTime5}
              endTime={this.state.endTime5}
              hours={this.state.hours5}
              floating={this.state.floating5}
              holiday={this.state.holiday5}
              vacation={this.state.vacation5}
              index="5"
              handleChange={this.handleChange}
            />
            <DayComponent
              date={this.state.date6}
              day={this.state.day6}
              startTime={this.state.startTime6}
              endTime={this.state.endTime6}
              hours={this.state.hours6}
              floating={this.state.floating6}
              holiday={this.state.holiday6}
              vacation={this.state.vacation6}
              index="6"
              handleChange={this.handleChange}
            />
            <DayComponent
              date={this.state.date7}
              day={this.state.day7}
              startTime={this.state.startTime7}
              endTime={this.state.endTime7}
              hours={this.state.hours7}
              floating={this.state.floating7}
              holiday={this.state.holiday7}
              vacation={this.state.vacation7}
              index="7"
              handleChange={this.handleChange}
            />
          </tbody>
        </table>

        <div style={{ marginTop: '1%', paddingLeft: '20%', paddingRight: '15%' }}>
          <span style={{ float: 'left' }}>
            <label style={{ paddingRight: '5px' }}>Upload Timesheet: </label>
            <input name='files' type="file"></input>
          </span>
          <span style={{ float: 'right' }}>
            <button style={{ padding: '5px 15px', backgroundColor: 'lightgreen' }} type="submit" onClick={this.handleSubmit}>Save</button>
          </span>
        </div >

      </div >
    );
  }
}

export default TimeSheeet;
