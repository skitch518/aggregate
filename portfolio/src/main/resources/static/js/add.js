const form = document.querySelector('form');

form.addEventListener('submit', async (event) => {
  event.preventDefault();

  const formData = new FormData(form);
  const holding = {
    ticker: formData.get('ticker').trim().toUpperCase(),
    shares: formData.get('shares'),
    purchasePrice: formData.get('purchasePrice')
  };

  try {
    const res = await fetch('/holdings', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify(holding)
    });

    if (!res.ok) throw new Error(`HTTP ${res.status}`);

    window.location.href = '/';
  } catch (err) {
    alert(`Failed to add holding: ${err.message}`);
  }
});