import React, { useEffect, useState } from "react"
import Gallery from "./Gallery";
import './Table.css';

const Table =()=>{
    // Displays the Gallery.js whenever view is true
    const [view, setView] = useState(false);
    function toggleView() {
        setView(!view);
        console.log("hi")
        console.log()
      }

    return(
        <>
        {/* display a table of the children the parents have */}
        <div className="tabletable">
            <table>
            <tr>
                    <th>Bracelet No.</th>
                    <th>Child Name</th>
                    <th>Current Location</th>
                    <th>Recent Photo</th>
                </tr>
            <tr className="user">
                    <td>01</td>
                    <td>Drake West</td>
                    <td>J. P. Wynne High School</td>
                    <td><input type="button" value="View Recent" onClick={toggleView}/></td>
                </tr>
            </table>
            {/* render the popup component if showPopup is true */}
            {view && (<Gallery />)}
        </div>
        </>

    );
}
export default Table