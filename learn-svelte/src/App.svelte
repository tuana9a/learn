<script>
  import Book from "./Book.svelte";

  let baseUrl = "http://localhost:8080";
  let books = [];
  let bookToInsert = {};

  const fetchAll = () =>
    fetch(baseUrl + "/api/books")
      .then((resp) => resp.json())
      .then((resp) => (books = Array.from(resp.data)));

  const onInsertBook = () =>
    fetch(baseUrl + "/api/book", {
      method: "POST",
      body: JSON.stringify(bookToInsert),
      headers: {
        "Content-Type": "application/json; charset=utf-8",
      },
    });

  fetchAll();
</script>

<main>
  <div>
    <label for="">Base Url</label>
    <input type="text" bind:value={baseUrl} />
  </div>
  <div>
    <button on:click={fetchAll}>Fetch All</button>
  </div>
  <table>
    <tr>
      <th>id</th>
      <th>name</th>
      <th>publisher</th>
      <th>buttons</th>
    </tr>
    <tr>
      <td><input type="text" /></td>
      <td><input type="text" bind:value={bookToInsert.name} /></td>
      <td><input type="text" bind:value={bookToInsert.publisher} /></td>
      <td><button on:click={onInsertBook}>Insert</button></td>
    </tr>
    {#each books as book}
      <Book
        {baseUrl}
        id={book.id}
        name={book.name}
        publisher={book.publisher}
      />
    {/each}
  </table>
</main>

<style>
</style>
