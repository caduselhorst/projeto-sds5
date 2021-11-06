import axios from "axios";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { isPropertyAssignment } from "typescript";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

    const [page, setPage] = useState<SalePage>({
        first: true,
        number: 0,
        totalElements: 0,
        totalPages: 0,
        last: true
    });

    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${page.number}&size=${page.size}&sort=date,desc`)
            .then(response => {
                setPage(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    },  [page.number, page.size]);

    return (
        <div className="table-responsive">
            <table className="table table-striped table-sm">
                <thead>
                    <tr>
                        <th>Data</th>
                        <th>Vendedor</th>
                        <th>Clientes visitados</th>
                        <th>Negócios fechados</th>
                        <th>Valor</th>
                    </tr>
                </thead>
                <tbody>
                    {page.content?.map(i =>(
                        <tr key={i.id}>
                            <td>{formatLocalDate(i.date, "dd/MM/yyyy")}</td>
                            <td>{i.seller.name}</td>
                            <td>{i.visited}</td>
                            <td>{i.deals}</td>
                            <td>{i.amount.toFixed(2)}</td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    );
  }
  
  export default DataTable;