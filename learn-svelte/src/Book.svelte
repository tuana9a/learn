<script>
  export let baseUrl = "http://localhost:8080";
  export let id = undefined;
  export let name = undefined;
  export let publisher = undefined;

  const onUpdateBook = () =>
    fetch(baseUrl + "/api/book", {
      method: "PUT",
      headers: {
        "Content-Type": "application/json; charset=utf-8;",
      },
      body: JSON.stringify({
        id: id,
        name: name,
        publisher: publisher,
      }),
    });

  const onDeleteBook = () =>
    fetch(baseUrl + "/api/book?id=" + id, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json; charset=utf-8;",
      },
    });
</script>

<tr>
  <td><input type="text" readonly bind:value={id} /></td>
  <td><input type="text" bind:value={name} /></td>
  <td><input type="text" bind:value={publisher} /></td>
  <td>
    <button on:click={onUpdateBook}>Update</button>
    <button on:click={onDeleteBook}>Delete</button>
  </td>
</tr>
