import React, { Component } from 'react';
// import { useForm } from "react-hook-form";
import axios from 'axios'

class Profile extends Component {
  email= "aasd12@markallen.com";

  constructor(props) {
   
    super(props);
    this.state = {
      id: "",
      firstName: "",
      lastNmae:"",
      phoneNumber: "",
      email: "",
      address: "",
      emergencyContactNumber: "",
      emergencyContactName: "",
      emergencyContactNumber2: "",
      emergencyContactName2: ""
    };

    this.handleInputChange = this.handleInputChange.bind(this);
  }

  componentDidMount() {
    axios.get(`http://localhost:8800/getEmployeeInfo?email=`+this.email)
      .then(res => {
        const {id,firstName, lastName, address, email, phoneNumber, emergencyContactNumber, emergencyContactName} = res.data;
        console.log(firstName)
        this.setState({id,firstName, lastName, address, email, phoneNumber, emergencyContactNumber, emergencyContactName});
      })
  }


  handleInputChange(event) {
    const target = event.target;
    const value = target.type === 'checkbox' ? target.checked : target.value;
    const name = target.name;

    this.setState({
      [name]: value
    });
  }

  render() {
    return (
      <form>
        
        <h2> Contact </h2>
         <label>
          <input
            name="phoneNum"
            type="text"
            value={this.state.phoneNumber}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          <input
            name="email"
            type="text"
            value={this.state.email}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          <input
            name="address"
            type="text"
            value={this.state.address}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <h2> Emergency Contact 1</h2>
        <label>
          <input
            name="emerCon1Name"
            type="text"
            value={this.state.emergencyContactName}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          <input
            name="emerCon1Cell"
            type="text"
            value={this.state.emergencyContactNumber}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <h2> Emergency Contact 2</h2>
        <label>
          <input
            name="emerCon2Name"
            type="text"
            value={this.state.emergencyContactName2}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          <input
            name="emerCon1Cell"
            type="text"
            value={this.state.emergencyContactNumber2}
            onChange={this.handleInputChange} />
        </label>
        <br />
      </form>
    );
  }
}

export default Profile;