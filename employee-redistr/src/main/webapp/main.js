let reimbursements = [];
let reimbursementsElement = document.querySelector('#imhere');

function Listreimbursements(reimbursements) {
    return `<table>
                <tr>
                    <th>Id</th>
                    <th>Type</th>
                    <th>Amount</th>
                    <th>Status</th>
                    <th>Employee</th>
                </tr>
                ${reimbursements.map(Listreimbursement).join(' ')}
            </table>`;
}

function Listreimbursement(reimbursement) {
    return `<tr>
                <td>${reimbursement.id}</td>
                <td>${reimbursement.type}</td>
                <td>${reimbursement.amount}</td>
                <td>${reimbursement.aproval}</td>
                <td>${reimbursement.employeuname}</td>
            </tr>`;
}

function updatereimbursementsElement() {
    reimbursementsElement.innerHTML = Listreimbursements(reimbursements);
}

function getreimbursements() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET','v1/reimbursements/');
    xhr.onload = function() { 
        reimbursements = JSON.parse(xhr.responseText); 
        updatereimbursementsElement();
    };
    xhr.send();
}
