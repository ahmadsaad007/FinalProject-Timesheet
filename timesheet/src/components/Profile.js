import React, { Component } from 'react';
// import { useForm } from "react-hook-form";

class Profile extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isGoing: true,
      numberOfGuests: 2,
      name: "Aiden",
      phoneNum: 6178161277,
      email: "kk@mall.com",
      address: "58 Shelley Cir",
      emerCon1Name: "Aria",
      emerCon1Cell: "7758258",
      emerCon2Name: "Matt",
      emerCon2Cell: "438438"
    };

    this.handleInputChange = this.handleInputChange.bind(this);
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
            value={this.state.phoneNum}
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
            value={this.state.emerCon1Name}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          <input
            name="emerCon1Cell"
            type="text"
            value={this.state.emerCon1Cell}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <h2> Emergency Contact 2</h2>
        <label>
          <input
            name="emerCon2Name"
            type="text"
            value={this.state.emerCon2Name}
            onChange={this.handleInputChange} />
        </label>
        <br />
        <label>
          <input
            name="emerCon1Cell"
            type="text"
            value={this.state.emerCon2Cell}
            onChange={this.handleInputChange} />
        </label>
        <br />
      </form>
    );
  }
}

export default Profile;