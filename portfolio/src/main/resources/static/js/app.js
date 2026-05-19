async function loadHoldings() {
  const container = document.getElementById('holdings');
  try {
    const res = await fetch('/holdings');
    if (!res.ok) throw new Error(`HTTP ${res.status}`);
    const holdings = await res.json();

    if (holdings.length === 0) {
      container.innerHTML = '<p>No holdings yet.</p>';
      return;
    }

    container.innerHTML = `
      <table>
        <thead>
          <tr>
            <th>Ticker</th>
            <th>Shares</th>
            <th>Purchase Price</th>
            <th>Current Price</th>
            <th>Current Value</th>
          </tr>
        </thead>
        <tbody>
          ${holdings.map(h => `
            <tr>
              <td>${h.ticker}</td>
              <td>${h.shares}</td>
              <td>$${h.purchasePrice}</td>
              <td>${h.currentPrice != null ? '$' + h.currentPrice : '—'}</td>
              <td>${h.currentValue != null ? '$' + h.currentValue : '—'}</td>
            </tr>
          `).join('')}
        </tbody>
      </table>
    `;
  } catch (err) {
    container.innerHTML = `<p>Failed to load holdings: ${err.message}</p>`;
  }
}

document.addEventListener('DOMContentLoaded', loadHoldings);