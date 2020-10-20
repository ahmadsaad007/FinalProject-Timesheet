import React from "react";

const DayComponent = ({
    date,
    day,
    startTime,
    endTime,
    hours,
    floating,
    holiday,
    vacation,
    index,
    handleChange }) => {
    return (
        <tr>
            <td>{day}</td>
            <td>
                <input value={date} disabled={true}></input>
            </td>
            <td>
                <input
                    defaultValue={startTime}
                    name={"startTime" + index}
                    onChange={(e) => handleChange(e)}
                ></input>
            </td>
            <td>
                <input
                    defaultValue={endTime}
                    name={"endTime" + index}
                    onChange={(e) => handleChange(e)}
                ></input>
            </td>
            <td>
                <input defaultValue={hours} name={"hours" + index}
                    onChange={(e) => handleChange(e)}></input>
            </td>
            <td>
                <input
                    type="radio"
                    value={floating}
                    onChange={(e) => handleChange(e)}
                ></input>
            </td>
            <td>
                <input
                    type="radio"
                    value={holiday}
                    onChange={(e) => handleChange(e)}
                ></input>
            </td>
            <td>
                <input
                    type="radio"
                    value={vacation}
                    onChange={(e) => handleChange(e)}
                ></input>
            </td>
        </tr>
    );
};
export default DayComponent;
