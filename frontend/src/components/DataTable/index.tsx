import axios from "axios";
import Pagination from "components/Pagination";
import { useEffect, useState } from "react";
import { SalePage } from "types/sale";
import { formatLocalDate } from "utils/format";
import { BASE_URL } from "utils/requests";

const DataTable = () => {

    const [page, setPage] = useState<SalePage>({
        first: true,
        number: 16,
        totalElements: 0,
        totalPages: 0,
        size: 10,
        last: false
    });
    const [activePage, setActivePage] = useState(0);

    const changePage = (index: number) => {
        setActivePage(index);
    }

    useEffect(() => {
        axios.get(`${BASE_URL}/sales?page=${activePage}&size=10&sort=date,desc`)
            .then(response => {
                setPage(response.data);
            })
            .catch(error => {
                console.error(error);
            });
    },  [activePage]);


    return (
        <>
            <Pagination page={page} onPageChange={changePage}/>
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
        </>
    );
  }
  
  export default DataTable;